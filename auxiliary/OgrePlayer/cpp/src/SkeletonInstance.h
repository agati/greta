/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class vib_auxiliary_player_ogre_natives_SkeletonInstance */

#ifndef _Included_vib_auxiliary_player_ogre_natives_SkeletonInstance
#define _Included_vib_auxiliary_player_ogre_natives_SkeletonInstance
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     vib_auxiliary_player_ogre_natives_SkeletonInstance
 * Method:    _hasBone
 * Signature: (JLjava/lang/String;)Z
 */
JNIEXPORT jboolean JNICALL Java_vib_auxiliary_player_ogre_natives_SkeletonInstance__1hasBone
  (JNIEnv *, jobject, jlong, jstring);

/*
 * Class:     vib_auxiliary_player_ogre_natives_SkeletonInstance
 * Method:    _getBone
 * Signature: (JLjava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_vib_auxiliary_player_ogre_natives_SkeletonInstance__1getBone__JLjava_lang_String_2
  (JNIEnv *, jobject, jlong, jstring);

/*
 * Class:     vib_auxiliary_player_ogre_natives_SkeletonInstance
 * Method:    _getRootBone
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_vib_auxiliary_player_ogre_natives_SkeletonInstance__1getRootBone
  (JNIEnv *, jobject, jlong);

/*
 * Class:     vib_auxiliary_player_ogre_natives_SkeletonInstance
 * Method:    _getNumBones
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_vib_auxiliary_player_ogre_natives_SkeletonInstance__1getNumBones
  (JNIEnv *, jobject, jlong);

/*
 * Class:     vib_auxiliary_player_ogre_natives_SkeletonInstance
 * Method:    _getBone
 * Signature: (JI)J
 */
JNIEXPORT jlong JNICALL Java_vib_auxiliary_player_ogre_natives_SkeletonInstance__1getBone__JI
  (JNIEnv *, jobject, jlong, jint);

/*
 * Class:     vib_auxiliary_player_ogre_natives_SkeletonInstance
 * Method:    delete
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_vib_auxiliary_player_ogre_natives_SkeletonInstance_delete
  (JNIEnv *, jobject, jlong);

#ifdef __cplusplus
}
#endif
#endif
