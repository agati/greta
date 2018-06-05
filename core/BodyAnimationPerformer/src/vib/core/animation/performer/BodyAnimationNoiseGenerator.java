/* This file is part of Greta.
 * Greta is free software: you can redistribute it and / or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
* 
* Greta is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.See the
* GNU General Public License for more details.
* 
* You should have received a copy of the GNU General Public License
* along with Greta.If not, see <http://www.gnu.org/licenses/>.
*//*
 * This file is part of VIB (Virtual Interactive Behaviour).
 */
package vib.core.animation.performer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import vib.core.animation.CharacterLowerBody;
import vib.core.animation.Frame;
import vib.core.animation.Skeleton;
import vib.core.animation.mocap.MocapXML;
import vib.core.animation.mocap.MotionSequence;
import vib.core.animation.mpeg4.bap.BAPFrame;
import vib.core.animation.mpeg4.bap.BAPFramesEmitter;
import vib.core.animation.mpeg4.bap.BAPFramesPerformer;
import vib.core.animation.mpeg4.bap.BAPType;
import vib.core.animation.mpeg4.bap.JointType;
import vib.core.util.Constants;
import vib.core.util.id.ID;
import vib.core.util.id.IDProvider;
import vib.core.util.math.Noise;
import vib.core.util.math.Quaternion;
import vib.core.util.math.Vec3d;
import vib.core.util.time.Timer;

/**
 *
 * @author Jing Huang
 */
public class BodyAnimationNoiseGenerator extends Thread implements BAPFramesEmitter {

    ArrayList<BAPFramesPerformer> _bapframesPerformer = new ArrayList<BAPFramesPerformer>();
    MotionSequence _ms;
    //Skeleton _sk_original = null;
    //Skeleton _sk = null;
    CharacterLowerBody _lowerbody = new CharacterLowerBody();
    double _intensityTorso = 0.2f;
    double _intensityHead = 1;
    private boolean requestStop = false;
    boolean _useHead = true;
    boolean _useTorso = true;
    boolean _useLowerBody = true;
    double step = 1;
    public BodyAnimationNoiseGenerator() {
        String currentDir = System.getProperty("user.dir");
        _ms = MocapXML.load(currentDir + "\\BehaviorRealizer\\AnimationLexicon\\noise.xml");
        this.start();
    }

    public BAPFrame generateNoise(int idx) {
        Frame frame = new Frame();
        if (isUseHead()) {
            computeHead(frame, idx);
        }
        if (isUseTorso()) {
            computeUpperBody(frame, idx);
        }
        if (isUseLowerBody()) {
            computeLowerBody(frame, idx);
        }
        //computeLowerBody(frame, idx);
        BAPFrame bapframe = getBapFrame(frame, idx);
        return bapframe;
    }

    public void setSkeleton(Skeleton sk) {
        //_sk = sk.clone();
        //_sk_original = sk.clone();
        //_lowerbody.setSkeleton(sk);
    }

    public boolean isUseHead() {
        return _useHead;
    }

    public void setUseHead(boolean useHead) {
        this._useHead = useHead;
    }

    public boolean isUseTorso() {
        return _useTorso;
    }

    public void setUseTorso(boolean useTorso) {
        this._useTorso = useTorso;
    }

    public boolean isUseLowerBody() {
        return _useLowerBody;
    }

    public void setUseLowerBody(boolean uselow) {
        this._useLowerBody = uselow;
    }


    /**
     *
     * @param info
     * @param index
     * @return the {@code BAPFrame} at the specified index
     */
    public BAPFrame getBapFrame(Frame info, int index) {
        BAPFrame bf = new BAPFrame();
        bf.setFrameNumber(index);
        HashMap<String, Quaternion> results = info.getRotations();
        Iterator iterator = results.keySet().iterator();
        while (iterator.hasNext()) {
            String name = (String) iterator.next();
            Quaternion q = results.get(name);
            Vec3d angle = q.getEulerAngleXYZ();
            JointType joint = JointType.get(name);
            BAPType z = joint.rotationZ;
            BAPType y = joint.rotationY;
            BAPType x = joint.rotationX;
            bf.setRadianValue(z, angle.z());
            bf.setRadianValue(y, angle.y());
            bf.setRadianValue(x, angle.x());
        }
        Vec3d translation = info.getRootTranslation();
        if (translation.x() != 0 || translation.y() != 0 || translation.z() != 0) {
            BAPType tx = BAPType.HumanoidRoot_tr_lateral;
            BAPType ty = BAPType.HumanoidRoot_tr_vertical;
            BAPType tz = BAPType.HumanoidRoot_tr_frontal;
            //System.out.println("translation: "+translation);
            double valuex = translation.x() * 10;
            double valuey = translation.y() * 10;
            double valuez = translation.z() * 10;
            bf.applyValue(tx, ((Number) valuex).intValue());
            bf.applyValue(ty, ((Number) valuey).intValue());
            bf.applyValue(tz, ((Number) valuez).intValue());
        }

        //_bframe = bf.clone();
        return bf;
    }

    void computeUpperBody(Frame frame, int idx) {
        int level = (int) (80.0);
        int level2 = (int) (123.0);
        //torso
        {
            Quaternion noisevl5 = new Quaternion();
            double d = Noise.noise((idx + Math.random()) / level, (idx + Math.random()) / level, (idx + Math.random()) / level);
            // double d1 = Noise.noise((idx + Math.random()) / level, (idx + Math.random()) / level, (idx + Math.random()) / level);
            double d2 = Noise.noise((idx + Math.random()) / level2, (idx + Math.random()) / level2, (idx + Math.random()) / level2);
            noisevl5.fromEulerXYZ((double) d / 45.0f * _intensityTorso, 0, (double) d2 / 60.0f * _intensityTorso);
            frame.accumulateRotation("vl3", noisevl5);

            Quaternion noisevt10 = new Quaternion();
            d = Noise.noise((idx + Math.random()) / level, (idx + Math.random()) / level, (idx + Math.random()) / level);

            d2 = Noise.noise((idx + Math.random()) / level2, (idx + Math.random()) / level2, (idx + Math.random()) / level2);
            noisevt10.fromEulerXYZ((double) d / 45.0f * _intensityTorso, 0, (double) d2 / 60.0f * _intensityTorso);
            frame.accumulateRotation("vt9", noisevt10);

            Quaternion noisevt1 = new Quaternion();
            d = Noise.noise((idx + Math.random()) / level, (idx + Math.random()) / level, (idx + Math.random()) / level);

            d2 = Noise.noise((idx + Math.random()) / level2, (idx + Math.random()) / level2, (idx + Math.random()) / level2);
            noisevt1.fromEulerXYZ((double) d / 30.0f * _intensityTorso, 0, (double) d2 / 60.0f * _intensityTorso);
            frame.accumulateRotation("vt3", noisevt1);
        }

        //root
        {
            Quaternion noisesacroiliac = new Quaternion();
            double d = Noise.noise((idx + Math.random()) / level, (idx + Math.random()) / level, (idx + Math.random()) / level);

            double d2 = Noise.noise((idx + Math.random()) / level2, (idx + Math.random()) / level2, (idx + Math.random()) / level2);
            noisesacroiliac.fromEulerXYZ((double) d / 20.0f * _intensityTorso, 0, (double) d2 / 20.0f * _intensityTorso);
            //frame.accumulateRotation("sacroiliac", noisesacroiliac);
            //frame.accumulateRotation("HumanoidRoot", noisesacroiliac.inverse());

        }

        //arm
//        {
//            level = (int) (40.0);
//            Quaternion noisel_elbow = new Quaternion();
//            double d = Noise.noise((idx + Math.random()) / level, (idx + Math.random()) / level, (idx + Math.random()) / level);
//            double d1 = Noise.noise((idx + Math.random()) / level, (idx + Math.random()) / level, (idx + Math.random()) / level);
//            double d2 = Noise.noise((idx + Math.random()) / level, (idx + Math.random()) / level, (idx + Math.random()) / level);
//            noisel_elbow.fromEulerXYZ(-(double) d / 5.0f, (double) d1 / 10.0f, (double) d2 / 10.0f);
//            frame.accumulateRotation("l_elbow", noisel_elbow);
//
//            Quaternion noiser_elbow = new Quaternion();
//            d = Noise.noise((idx + Math.random()) / level, (idx + Math.random()) / level, (idx + Math.random()) / level);
//            d1 = Noise.noise((idx + Math.random()) / level, (idx + Math.random()) / level, (idx + Math.random()) / level);
//            d2 = Noise.noise((idx + Math.random()) / level, (idx + Math.random()) / level, (idx + Math.random()) / level);
//            noiser_elbow.fromEulerXYZ(-(double) d / 5.0f, (double) d1 / 10.0f, (double) d2 / 10.0f);
//            frame.accumulateRotation("r_elbow", noiser_elbow);
//
//            Quaternion noisel_shoulder = new Quaternion();
//            d = Noise.noise((idx + Math.random()) / level, (idx + Math.random()) / level, (idx + Math.random()) / level);
//            d1 = Noise.noise((idx + Math.random()) / level, (idx + Math.random()) / level, (idx + Math.random()) / level);
//            d2 = Noise.noise((idx + Math.random()) / level, (idx + Math.random()) / level, (idx + Math.random()) / level);
//            noisel_shoulder.fromEulerXYZ(-(double) d / 50.0f, (double) d1 / 50.0f, (double) d2 / 50.0f);
//            frame.accumulateRotation("l_shoulder", noisel_shoulder);
//
//            Quaternion noiser_shoulder = new Quaternion();
//            d = Noise.noise((idx + Math.random()) / level, (idx + Math.random()) / level, (idx + Math.random()) / level);
//            d1 = Noise.noise((idx + Math.random()) / level, (idx + Math.random()) / level, (idx + Math.random()) / level);
//            d2 = Noise.noise((idx + Math.random()) / level, (idx + Math.random()) / level, (idx + Math.random()) / level);
//            noiser_shoulder.fromEulerXYZ(-(double) d / 50.0f, (double) d1 / 50.0f, (double) d2 / 50.0f);
//            frame.accumulateRotation("r_shoulder", noiser_shoulder);
//        }
    }

    void computeHead(Frame frame, int idx) {
        int level = (int) (80.0);

        //head
        {
//            Quaternion noise5 = new Quaternion();
            double d = Noise.noise((idx + Math.random()) / level, (idx + Math.random()) / level, (idx + Math.random()) / level);
//            noise5.fromEulerXYZ(0, 0, (double) d / 30.0f * _intensityHead);
//            frame.accumulateRotation("vc1", noise5);

            Quaternion noise6 = new Quaternion();
            d = Noise.noise((idx + Math.random()) / level, (idx + Math.random()) / level, (idx + Math.random()) / level);
            noise6.fromEulerXYZ((double) d / 15.0f * _intensityHead, 0, 0);
            frame.accumulateRotation("vc2", noise6);

            Quaternion noise7 = new Quaternion();
            d = Noise.noise((idx + Math.random()) / level, (idx + Math.random()) / level, (idx + Math.random()) / level);
            noise7.fromEulerXYZ(0, (double) d / 20.0f * _intensityHead, 0);
            frame.accumulateRotation("vc3", noise7);

            Quaternion noise2 = new Quaternion();
            d = Noise.noise((idx + Math.random()) / level, (idx + Math.random()) / level, (idx + Math.random()) / level);
            double d1 = Noise.noise((idx + Math.random()) / level, (idx + Math.random()) / level, (idx + Math.random()) / level);
            double d2 = Noise.noise((idx + Math.random()) / level, (idx + Math.random()) / level, (idx + Math.random()) / level);
            noise2.fromEulerXYZ((double) d / 30.0f * _intensityHead, (double) d1 / 50.0f * _intensityHead, (double) d2 / 30.0f * _intensityHead);
            frame.accumulateRotation("vc5", noise2);
        }


    }
    int currentIdx = 0;
    int signed = 1;

    void computeLowerBody(Frame frame, int idx) {
        if (_ms == null) {
            return;
        }

        ArrayList<Frame> frames = _ms.getSequence();
        int size = frames.size();

        Frame current = frames.get(currentIdx);
        {
            frame.setRootTranslation(current.getRootTranslation());
            frame.addRotation("HumanoidRoot", Quaternion.slerp(new Quaternion(), current.getRotation("HumanoidRoot"), 0.8f, true));
            frame.addRotation("vl5", Quaternion.slerp(new Quaternion(), current.getRotation("HumanoidRoot").inverse(), 0.8f, true));
            frame.addRotation("l_knee", current.getRotation("l_knee"));
            frame.addRotation("r_knee", current.getRotation("r_knee"));
            frame.addRotation("l_ankle", current.getRotation("l_ankle"));
            frame.addRotation("r_ankle", current.getRotation("r_ankle"));
            frame.addRotation("l_hip", current.getRotation("l_hip"));
            frame.addRotation("r_hip", current.getRotation("r_hip"));
        }
        if (currentIdx >= size) {
            currentIdx = size - 1;
            signed = signed * -1;
        } else if (currentIdx < 0) {
            currentIdx = 0;
            signed = signed * -1;;
        }
        currentIdx += signed;
        if(currentIdx >= size){
            currentIdx = size - 1;
            signed = signed * -1;
        } else if (currentIdx < 0) {
            currentIdx = 0;
            signed = signed * -1;
        }
    }

    @Override
    public void addBAPFramesPerformer(BAPFramesPerformer bapfp) {
        if (bapfp != null) {
            _bapframesPerformer.add(bapfp);
        }
    }

    @Override
    public void removeBAPFramesPerformer(BAPFramesPerformer bapfp) {
        _bapframesPerformer.remove(bapfp);
    }

    public void requestStop() {
        requestStop = true;
    }

    public void run() {
        while (!requestStop) {
            ArrayList<BAPFrame> frames = new ArrayList<BAPFrame>();
            long time = Timer.getTimeMillis();
            int _current = (int) (time / 1000.0 * Constants.FRAME_PER_SECOND + 0.5);
            for (int i = 0; i < Constants.FRAME_PER_SECOND; ++i) {
                BAPFrame bf = generateNoise(_current);
                frames.add(bf);
                _current++;
            }
            ID id = IDProvider.createID("BodyAnimationBapBlender");
            sendFrames(frames, id);
            Timer.sleep(Math.max(1, 1000 - (Timer.getTimeMillis() - time)));
        }
    }

    void sendFrames(List<BAPFrame> bapframes, ID requestId) {
        for (int i = 0; i < _bapframesPerformer.size(); ++i) {
            BAPFramesPerformer performer = _bapframesPerformer.get(i);
            performer.performBAPFrames(bapframes, requestId);
        }
    }

    public void setIntensityHead(double v) {
        _intensityHead = v;
    }

    public double getIntensityHead() {
        return _intensityHead;
    }

    public void setIntensityTorso(double v) {
        _intensityTorso = v;
    }

    public double getIntensityTorso() {
        return _intensityTorso;
    }

    public void setStep(double step){
        this.step = step;
        int lstep = this.step > 1 ? (int)(this.step) : 1;
        signed = lstep;
    }

    public double getStep(){
        return step;
    }
}
