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

package com.liferay.frontend.js.portlet.extender.internal.portlet;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author Ray Augé
 * @author Iván Zaera Avellón
 */
public class JSPortlet extends MVCPortlet {

	public JSPortlet(String name, String version) {
		_name = name;
		_version = version;
	}

	@Override
	public void render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		try {
			PrintWriter printWriter = renderResponse.getWriter();

			String portletElementId =
				"js-portlet-" + renderResponse.getNamespace();

			printWriter.print(
				StringUtil.replace(
					_HTML_TPL, new String[] {"[$PORTLET_ELEMENT_ID$]"},
					new String[] {portletElementId}));

			printWriter.print(
				StringUtil.replace(
					_JAVA_SCRIPT_TPL,
					new String[] {
						"[$CONTEXT_PATH$]", "[$PORTLET_ELEMENT_ID$]",
						"[$PORTLET_NAMESPACE$]", "[$PACKAGE_NAME$]",
						"[$PACKAGE_VERSION$]"
					},
					new String[] {
						renderRequest.getContextPath(), portletElementId,
						renderResponse.getNamespace(), _name, _version
					}));

			printWriter.flush();
		}
		catch (IOException ioe) {
			_log.error("Unable to render HTML output", ioe);
		}
	}

	private static String _loadTemplate(String name) {
		InputStream inputStream = JSPortlet.class.getResourceAsStream(
			"dependencies/" + name);

		try {
			return StringUtil.read(inputStream);
		}
		catch (Exception e) {
			_log.error("Unable to read template " + name, e);
		}

		return StringPool.BLANK;
	}

	private static final String _HTML_TPL;

	private static final String _JAVA_SCRIPT_TPL;

	private static final Log _log = LogFactoryUtil.getLog(JSPortlet.class);

	static {
		_HTML_TPL = _loadTemplate("bootstrap.html.tpl");
		_JAVA_SCRIPT_TPL = _loadTemplate("bootstrap.js.tpl");
	}

	private final String _name;
	private final String _version;

}