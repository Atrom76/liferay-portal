/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.powwow.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for PowwowServer. This utility wraps
 * {@link com.liferay.powwow.service.impl.PowwowServerLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Shinn Lok
 * @see PowwowServerLocalService
 * @see com.liferay.powwow.service.base.PowwowServerLocalServiceBaseImpl
 * @see com.liferay.powwow.service.impl.PowwowServerLocalServiceImpl
 * @generated
 */
public class PowwowServerLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.powwow.service.impl.PowwowServerLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the powwow server to the database. Also notifies the appropriate model listeners.
	*
	* @param powwowServer the powwow server
	* @return the powwow server that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.powwow.model.PowwowServer addPowwowServer(
		com.liferay.powwow.model.PowwowServer powwowServer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPowwowServer(powwowServer);
	}

	/**
	* Creates a new powwow server with the primary key. Does not add the powwow server to the database.
	*
	* @param powwowServerId the primary key for the new powwow server
	* @return the new powwow server
	*/
	public static com.liferay.powwow.model.PowwowServer createPowwowServer(
		long powwowServerId) {
		return getService().createPowwowServer(powwowServerId);
	}

	/**
	* Deletes the powwow server with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param powwowServerId the primary key of the powwow server
	* @return the powwow server that was removed
	* @throws PortalException if a powwow server with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.powwow.model.PowwowServer deletePowwowServer(
		long powwowServerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePowwowServer(powwowServerId);
	}

	/**
	* Deletes the powwow server from the database. Also notifies the appropriate model listeners.
	*
	* @param powwowServer the powwow server
	* @return the powwow server that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.powwow.model.PowwowServer deletePowwowServer(
		com.liferay.powwow.model.PowwowServer powwowServer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePowwowServer(powwowServer);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.powwow.model.impl.PowwowServerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.powwow.model.impl.PowwowServerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.powwow.model.PowwowServer fetchPowwowServer(
		long powwowServerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchPowwowServer(powwowServerId);
	}

	/**
	* Returns the powwow server with the primary key.
	*
	* @param powwowServerId the primary key of the powwow server
	* @return the powwow server
	* @throws PortalException if a powwow server with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.powwow.model.PowwowServer getPowwowServer(
		long powwowServerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPowwowServer(powwowServerId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the powwow servers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.powwow.model.impl.PowwowServerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of powwow servers
	* @param end the upper bound of the range of powwow servers (not inclusive)
	* @return the range of powwow servers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.powwow.model.PowwowServer> getPowwowServers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPowwowServers(start, end);
	}

	/**
	* Returns the number of powwow servers.
	*
	* @return the number of powwow servers
	* @throws SystemException if a system exception occurred
	*/
	public static int getPowwowServersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPowwowServersCount();
	}

	/**
	* Updates the powwow server in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param powwowServer the powwow server
	* @return the powwow server that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.powwow.model.PowwowServer updatePowwowServer(
		com.liferay.powwow.model.PowwowServer powwowServer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePowwowServer(powwowServer);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.liferay.powwow.model.PowwowServer addPowwowServer(
		long userId, java.lang.String name, java.lang.String providerType,
		java.lang.String url, java.lang.String apiKey, java.lang.String secret,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addPowwowServer(userId, name, providerType, url, apiKey,
			secret, serviceContext);
	}

	public static void checkPowwowServers()
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().checkPowwowServers();
	}

	public static java.util.List<com.liferay.powwow.model.PowwowServer> getPowwowServers(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPowwowServers(start, end, obc);
	}

	public static java.util.List<com.liferay.powwow.model.PowwowServer> getPowwowServers(
		java.lang.String providerType, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPowwowServers(providerType, active);
	}

	public static int getPowwowServersCount(java.lang.String providerType,
		boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPowwowServersCount(providerType, active);
	}

	public static com.liferay.powwow.model.PowwowServer updatePowwowServer(
		long powwowServerId, java.lang.String name,
		java.lang.String providerType, java.lang.String url,
		java.lang.String apiKey, java.lang.String secret,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updatePowwowServer(powwowServerId, name, providerType, url,
			apiKey, secret, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static PowwowServerLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PowwowServerLocalService.class.getName());

			if (invokableLocalService instanceof PowwowServerLocalService) {
				_service = (PowwowServerLocalService)invokableLocalService;
			}
			else {
				_service = new PowwowServerLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PowwowServerLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(PowwowServerLocalService service) {
	}

	private static PowwowServerLocalService _service;
}