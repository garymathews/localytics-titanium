/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2022 by Axway, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package com.localytics;

import java.util.Date;
import java.util.Map;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.proxy.ActivityProxy;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;

import com.localytics.android.Localytics;
import com.localytics.android.LocalyticsActivityLifecycleCallbacks;
import com.localytics.gcm.GCMRegistrar;

@Kroll.module(name = "Localytics", id = "com.localytics")
public class LocalyticsModule extends KrollModule
{
	// Profiles
	@Kroll.constant
	public static final String PROFILE_SCOPE_ORG = "org";
	@Kroll.constant
	public static final String PROFILE_SCOPE_APP = "app";

	// Developer Options
	/*@Kroll.constant public static final String DISMISS_BUTTON_LOCATION_LEFT = "left";
	@Kroll.constant public static final String DISMISS_BUTTON_LOCATION_RIGHT = "right";*/

	private static final String PROP_SENDER_ID = "com.localytics.android_push_sender_id";

	public LocalyticsModule()
	{
		super();
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app)
	{
		// buggy, build fails when this isn't here
	}

	/*******************
	 * Integration
	 ******************/

	@Kroll.method
	public void integrate()
	{
		Localytics.integrate(TiApplication.getInstance().getApplicationContext());
	}

	@Kroll.method
	public void upload()
	{
		Localytics.upload();
	}

	/*******************
	 * Automatic Integration
	 ******************/

	@Kroll.method
	public void autoIntegrate()
	{
		Application app = TiApplication.getInstance();
		app.registerActivityLifecycleCallbacks(new LocalyticsActivityLifecycleCallbacks(true));
	}

	/*******************
	 * Analytics
	 ******************/

	@Kroll.method
	public boolean isOptedOut()
	{
		return Localytics.isOptedOut();
	}

	@Kroll.method
	public void setOptedOut(boolean newOptOut)
	{
		Localytics.setOptedOut(newOptOut);
	}

	@Kroll.method
	public void pauseDataUploading(boolean pauseDataUploading)
	{
		Localytics.pauseDataUploading(pauseDataUploading);
	}

	@Kroll.method
	public void setPrivacyOptedOut(boolean privacyOptedOut)
	{
		Localytics.setPrivacyOptedOut(privacyOptedOut);
	}

	@Kroll.method
	public void setCustomerIdWithPrivacyOptedOut(String cid, boolean optedOut)
	{
		Localytics.setCustomerIdWithPrivacyOptedOut(cid, optedOut);
	}

	@Kroll.method
	public void openSession()
	{
		Localytics.openSession();
	}

	@Kroll.method
	public void closeSession()
	{
		Localytics.closeSession();
	}

	@Kroll.method
	public void tagEvent(String eventName, @Kroll.argument(optional = true) Map attributes,
						 @Kroll.argument(optional = true) int customerValueIncrease)
	{
		Localytics.tagEvent(eventName, attributes, customerValueIncrease);
	}

	@Kroll.method
	public void tagScreen(String screen)
	{
		Localytics.tagScreen(screen);
	}

	@Kroll.method
	public void setCustomDimension(int dimension, String value)
	{
		Localytics.setCustomDimension(dimension, value);
	}

	@Kroll.method
	public String getCustomDimension(int dimension)
	{
		return Localytics.getCustomDimension(dimension);
	}

	/*******************
	 * Profiles
	 ******************/

	@Kroll.method
	public void setProfileAttribute(String attributeName, Object attributeValue,
									@Kroll.argument(optional = true) String scope)
	{
		if (attributeValue instanceof Integer) {
			Localytics.setProfileAttribute(attributeName, (Integer) attributeValue, Utils.getProfileScope(scope));
		} else if (attributeValue instanceof String) {
			Localytics.setProfileAttribute(attributeName, (String) attributeValue, Utils.getProfileScope(scope));
		} else if (attributeValue instanceof Date) {
			Localytics.setProfileAttribute(attributeName, (Date) attributeValue, Utils.getProfileScope(scope));
		} else if (attributeValue instanceof Object[]) {
			Object[] cast = (Object[]) attributeValue;
			Object first = Utils.getFirst(cast);
			if (first instanceof Integer) {
				long[] longs = Utils.extractLongArray(cast);
				if (longs != null) {
					Localytics.setProfileAttribute(attributeName, longs, Utils.getProfileScope(scope));
				}
			} else if (first instanceof String) {
				String[] strings = Utils.extractStringArray(cast);
				if (strings != null) {
					Localytics.setProfileAttribute(attributeName, strings, Utils.getProfileScope(scope));
				}
			} else if (first instanceof Date) {
				Date[] dates = Utils.extractDateArray(cast);
				if (dates != null) {
					Localytics.setProfileAttribute(attributeName, dates, Utils.getProfileScope(scope));
				}
			}
		}
	}

	@Kroll.method
	public void addProfileAttributesToSet(String attributeName, Object attributeValue,
										  @Kroll.argument(optional = true) String scope)
	{
		if (attributeValue instanceof Object[]) {
			Object[] cast = (Object[]) attributeValue;
			Object first = Utils.getFirst(cast);
			if (first instanceof Integer) {
				long[] longs = Utils.extractLongArray(cast);
				if (longs != null) {
					Localytics.addProfileAttributesToSet(attributeName, longs, Utils.getProfileScope(scope));
				}
			} else if (first instanceof String) {
				String[] strings = Utils.extractStringArray(cast);
				if (strings != null) {
					Localytics.addProfileAttributesToSet(attributeName, strings, Utils.getProfileScope(scope));
				}
			} else if (first instanceof Date) {
				Date[] dates = Utils.extractDateArray(cast);
				if (dates != null) {
					Localytics.addProfileAttributesToSet(attributeName, dates, Utils.getProfileScope(scope));
				}
			}
		}
	}

	@Kroll.method
	public void removeProfileAttributesFromSet(String attributeName, Object attributeValue,
											   @Kroll.argument(optional = true) String scope)
	{
		if (attributeValue instanceof Object[]) {
			Object[] cast = (Object[]) attributeValue;
			Object first = Utils.getFirst(cast);
			if (first instanceof Integer) {
				long[] longs = Utils.extractLongArray(cast);
				if (longs != null) {
					Localytics.removeProfileAttributesFromSet(attributeName, longs, Utils.getProfileScope(scope));
				}
			} else if (first instanceof String) {
				String[] strings = Utils.extractStringArray(cast);
				if (strings != null) {
					Localytics.removeProfileAttributesFromSet(attributeName, strings, Utils.getProfileScope(scope));
				}
			} else if (first instanceof Date) {
				Date[] dates = Utils.extractDateArray(cast);
				if (dates != null) {
					Localytics.removeProfileAttributesFromSet(attributeName, dates, Utils.getProfileScope(scope));
				}
			}
		}
	}

	@Kroll.method
	public void incrementProfileAttribute(String attributeName, int incrementValue,
										  @Kroll.argument(optional = true) String scope)
	{
		Localytics.incrementProfileAttribute(attributeName, incrementValue, Utils.getProfileScope(scope));
	}

	@Kroll.method
	public void decrementProfileAttribute(String attributeName, int incrementValue,
										  @Kroll.argument(optional = true) String scope)
	{
		Localytics.decrementProfileAttribute(attributeName, incrementValue, Utils.getProfileScope(scope));
	}

	@Kroll.method
	public void deleteProfileAttribute(String attributeName, @Kroll.argument(optional = true) String scope)
	{
		Localytics.deleteProfileAttribute(attributeName, Utils.getProfileScope(scope));
	}

	/*******************
	 * Marketing
	 ******************/

	@Kroll.method
	public void setInAppMessageDisplayActivity(ActivityProxy proxy)
	{
		if (proxy instanceof ActivityProxy) {
			Activity activity = proxy.getActivity();
			if (activity instanceof FragmentActivity) {
				Localytics.setInAppMessageDisplayActivity((FragmentActivity) activity);
			} else {
				LocalyticsLog.d("Activity is not an instance of FragmentActivity");
			}
		}
	}

	@Kroll.method
	public void dismissCurrentInAppMessage()
	{
		Localytics.dismissCurrentInAppMessage();
	}

	@Kroll.method
	public void clearInAppMessageDisplayActivity()
	{
		Localytics.clearInAppMessageDisplayActivity();
	}

	@Kroll.method
	public void triggerInAppMessage(String triggerName, @Kroll.argument(optional = true) Map attributes)
	{
		Localytics.triggerInAppMessage(triggerName, attributes);
	}

	@Kroll.method
	public void registerPush()
	{
		String senderId = TiApplication.getInstance().getAppProperties().getString(PROP_SENDER_ID, "");
		if (!TextUtils.isEmpty(senderId)) {
			String registrationId = GCMRegistrar.getRegistrationId(TiApplication.getInstance());
			if (TextUtils.isEmpty(registrationId)) {
				GCMRegistrar.register(TiApplication.getInstance(), senderId);
			}
		}
	}

	@Kroll.method
	public void setPushDisabled(boolean disable)
	{
		LocalyticsLog.e("The \"setPushDisabled\" method has been removed by the Localytics SDK");
	}

	@Kroll.method
	public boolean isPushDisabled()
	{
		LocalyticsLog.e("The \"isPushDisabled\" method has been removed by the Localytics SDK");
		return false;
	}

	@Kroll.method
	public void setTestModeEnabled(boolean enabled)
	{
		Localytics.setTestModeEnabled(enabled);
	}

	@Kroll.method
	public boolean isTestModeEnabled()
	{
		return Localytics.isTestModeEnabled();
	}

	// handlePushNotificationOpened
	// handleTestMode
	// setInAppMessageDismissButtonImage
	// setInAppMessageDismissButtonImage
	// addMessagingListener
	// removeMessagingListener

	/*******************
	 * User Information
	 ******************/

	@Kroll.method
	public void setIdentifier(String key, String value)
	{
		Localytics.setIdentifier(key, value);
	}

	@Kroll.method
	public void setCustomerId(String customerId)
	{
		Localytics.setCustomerId(customerId);
	}

	@Kroll.method
	public String getIdentifier(String key)
	{
		return Localytics.getIdentifier(key);
	}

	// setLocation

	/*******************
	 * Developer Options
	 ******************/

	@Kroll.method
	public void setLoggingEnabled(boolean enabled)
	{
		Localytics.setLoggingEnabled(enabled);
	}

	@Kroll.method
	public boolean isLoggingEnabled()
	{
		return Localytics.isLoggingEnabled();
	}

	@Kroll.method
	public void setSessionTimeoutInterval(int seconds)
	{
		LocalyticsLog.e("The \"setSessionTimeoutInterval\" method has been removed by the Localytics SDK");
	}

	@Kroll.method
	public int getSessionTimeoutInterval()
	{
		LocalyticsLog.e("The \"getSessionTimeoutInterval\" method has been removed by the Localytics SDK");
		return -1;
	}

	@Kroll.method
	public String getInstallId()
	{
		return Localytics.getInstallId();
	}

	@Kroll.method
	public String getAppKey()
	{
		return Localytics.getAppKey();
	}

	@Kroll.method
	public String getLibraryVersion()
	{
		return Localytics.getLibraryVersion();
	}

	/*@Kroll.method
	public void setInAppMessageDismissButtonLocation(String buttonLocation)
    {
		if (buttonLocation.equals(DISMISS_BUTTON_LOCATION_LEFT)) {
			Localytics.setInAppMessageDismissButtonLocation(InAppMessageDismissButtonLocation.LEFT);
		} else if (buttonLocation.equals(DISMISS_BUTTON_LOCATION_RIGHT)) {
			Localytics.setInAppMessageDismissButtonLocation(InAppMessageDismissButtonLocation.RIGHT);
		} else {
			throw new IllegalArgumentException("buttonLocation must be either 'left' or 'right'.");
		}
    }

	@Kroll.method
    public String getInAppMessageDismissButtonLocation()
    {
		InAppMessageDismissButtonLocation location = Localytics.getInAppMessageDismissButtonLocation();
		switch(location)
		{
			case LEFT:
				return DISMISS_BUTTON_LOCATION_LEFT;
			case RIGHT:
				return DISMISS_BUTTON_LOCATION_RIGHT;
			default:
				return null;
		}
    }*/
}
