/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class vib_auxiliary_player_ogre_natives_ResourceGroupManager */

#ifndef _Included_vib_auxiliary_player_ogre_natives_ResourceGroupManager
#define _Included_vib_auxiliary_player_ogre_natives_ResourceGroupManager
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     vib_auxiliary_player_ogre_natives_ResourceGroupManager
 * Method:    _getSingleton
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_vib_auxiliary_player_ogre_natives_ResourceGroupManager__1getSingleton
  (JNIEnv *, jclass);

/*
 * Class:     vib_auxiliary_player_ogre_natives_ResourceGroupManager
 * Method:    getDEFAULT_RESOURCE_GROUP_NAME
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_vib_auxiliary_player_ogre_natives_ResourceGroupManager_getDEFAULT_1RESOURCE_1GROUP_1NAME
  (JNIEnv *, jclass);

/*
 * Class:     vib_auxiliary_player_ogre_natives_ResourceGroupManager
 * Method:    _isResourceGroupInitialised
 * Signature: (JLjava/lang/String;)Z
 */
JNIEXPORT jboolean JNICALL Java_vib_auxiliary_player_ogre_natives_ResourceGroupManager__1isResourceGroupInitialised
  (JNIEnv *, jobject, jlong, jstring);

/*
 * Class:     vib_auxiliary_player_ogre_natives_ResourceGroupManager
 * Method:    _addResourceLocation
 * Signature: (JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
 */
JNIEXPORT void JNICALL Java_vib_auxiliary_player_ogre_natives_ResourceGroupManager__1addResourceLocation
  (JNIEnv *, jobject, jlong, jstring, jstring, jstring, jboolean);

/*
 * Class:     vib_auxiliary_player_ogre_natives_ResourceGroupManager
 * Method:    _initialiseAllResourceGroups
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_vib_auxiliary_player_ogre_natives_ResourceGroupManager__1initialiseAllResourceGroups
  (JNIEnv *, jobject, jlong);

/*
 * Class:     vib_auxiliary_player_ogre_natives_ResourceGroupManager
 * Method:    _resourceExists
 * Signature: (JLjava/lang/String;Ljava/lang/String;)Z
 */
JNIEXPORT jboolean JNICALL Java_vib_auxiliary_player_ogre_natives_ResourceGroupManager__1resourceExists
  (JNIEnv *, jobject, jlong, jstring, jstring);

/*
 * Class:     vib_auxiliary_player_ogre_natives_ResourceGroupManager
 * Method:    delete
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_vib_auxiliary_player_ogre_natives_ResourceGroupManager_delete
  (JNIEnv *, jobject, jlong);

#ifdef __cplusplus
}
#endif
#endif