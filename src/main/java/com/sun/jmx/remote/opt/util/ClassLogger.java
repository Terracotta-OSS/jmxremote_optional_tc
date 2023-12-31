/*
 * @(#)ClassLogger.java	1.3
 *
 * 
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * Copyright (c) 2007 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * The contents of this file are subject to the terms of either the GNU General
 * Public License Version 2 only ("GPL") or the Common Development and
 * Distribution License("CDDL")(collectively, the "License"). You may not use
 * this file except in compliance with the License. You can obtain a copy of the
 * License at http://opendmk.dev.java.net/legal_notices/licenses.txt or in the 
 * LEGAL_NOTICES folder that accompanied this code. See the License for the 
 * specific language governing permissions and limitations under the License.
 * 
 * When distributing the software, include this License Header Notice in each
 * file and include the License file found at
 *     http://opendmk.dev.java.net/legal_notices/licenses.txt
 * or in the LEGAL_NOTICES folder that accompanied this code.
 * Sun designates this particular file as subject to the "Classpath" exception
 * as provided by Sun in the GPL Version 2 section of the License file that
 * accompanied this code.
 * 
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * 
 *       "Portions Copyrighted [year] [name of copyright owner]"
 * 
 * Contributor(s):
 * 
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding
 * 
 *       "[Contributor] elects to include this software in this distribution
 *        under the [CDDL or GPL Version 2] license."
 * 
 * If you don't indicate a single choice of license, a recipient has the option
 * to distribute your version of this file under either the CDDL or the GPL
 * Version 2, or to extend the choice of license to its licensees as provided
 * above. However, if you add GPL Version 2 code and therefore, elected the
 * GPL Version 2 license, then the option applies only if the new code is made
 * subject to such option by the copyright holder.
 * 
 */

package com.sun.jmx.remote.opt.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClassLogger {

    private static final boolean ok;
    private final String className;
    private final Logger logger;

    static {
	boolean loaded = false;
	try {
	    Class c = Logger.class;
	    loaded = true;
	} catch (Error e) {
	    // OK.
	    // slf4j is not available in this jvm.
	}
	ok = loaded;
    }

    public ClassLogger(String subsystem, String className) {
	if (ok)
	    logger = LoggerFactory.getLogger(subsystem);
	else
	    logger = null;
	this.className = className;
    }

    public final boolean traceOn() {
	return finerOn();
    }

    public final boolean debugOn() {
	return finestOn();
    }

    public final boolean warningOn() {
	return ok && logger.isWarnEnabled();
    }

    public final boolean infoOn() {
	return ok && logger.isInfoEnabled();
    }

    public final boolean configOn() {
	return ok && logger.isInfoEnabled();
    }

    public final boolean fineOn() {
	return ok && logger.isDebugEnabled();
    }

    public final boolean finerOn() {
	return ok && logger.isDebugEnabled();
    }

    public final boolean finestOn() {
	return ok && logger.isDebugEnabled();
    }

    public final void debug(String func, String msg) {
	finest(func,msg);
    }

    public final void debug(String func, Throwable t) {
	finest(func,t);
    }

    public final void debug(String func, String msg, Throwable t) {
	finest(func,msg,t);
    }

    public final void trace(String func, String msg) {
	finer(func,msg);
    }

    public final void trace(String func, Throwable t) {
	finer(func,t);
    }

    public final void trace(String func, String msg, Throwable t) {
	finer(func,msg,t);
    }

    public final void error(String func, String msg) {
	severe(func,msg);
    }

    public final void error(String func, Throwable t) {
	severe(func,t);
    }

    public final void error(String func, String msg, Throwable t) {
	severe(func,msg,t);
    }

    public final void finest(String func, String msg) {
	if (ok)
	    logger.debug(className + "." + func + " - " + msg);
    }

    public final void finest(String func, Throwable t) {
	if (ok)
	    logger.debug(className + "." + func, t);
    }

    public final void finest(String func, String msg, Throwable t) {
	if (ok)
	    logger.debug(className + "." + func + " - " + msg, t);
    }

    public final void finer(String func, String msg) {
	if (ok)
	    logger.debug(className + "." + func + " - " + msg);
    }

    public final void finer(String func, Throwable t) {
	if (ok)
	    logger.debug(className + "." + func, t);
    }

    public final void finer(String func, String msg, Throwable t) {
	if (ok)
	    logger.debug(className + "." + func + " - " + msg, t);
    }

    public final void fine(String func, String msg) {
	if (ok)
	    logger.debug(className + "." + func + " - " + msg);
    }

    public final void fine(String func, Throwable t) {
	if (ok)
	    logger.debug(className + "." + func, t);
    }

    public final void fine(String func, String msg, Throwable t) {
	if (ok)
	    logger.debug(className + "." + func + " - " + msg, t);
    }

    public final void config(String func, String msg) {
	if (ok)
	    logger.info(className + "." + func + " - " + msg);
    }

    public final void config(String func, Throwable t) {
	if (ok)
	    logger.info(className + "." + func, t);
    }

    public final void config(String func, String msg, Throwable t) {
	if (ok)
	    logger.info(className + "." + func + " - " + msg, t);
    }

    public final void info(String func, String msg) {
	if (ok)
	    logger.info(className + "." + func + " - " + msg);
    }

    public final void info(String func, Throwable t) {
	if (ok)
	    logger.info(className + "." + func, t);
    }

    public final void info(String func, String msg, Throwable t) {
	if (ok)
	    logger.info(className + "." + func + " - " + msg, t);
    }

    public final void warning(String func, String msg) {
	if (ok)
	    logger.warn(className + "." + func + " - " + msg);
    }

    public final void warning(String func, Throwable t) {
	if (ok)
	    logger.warn(className + "." + func, t);
    }

    public final void warning(String func, String msg, Throwable t) {
	if (ok)
	    logger.warn(className + "." + func + " - " + msg, t);
    }

    public final void severe(String func, String msg) {
	if (ok)
	    logger.error(className + "." + func + " - " + msg);
    }

    public final void severe(String func, Throwable t) {
	if (ok)
	    logger.error(className + "." + func, t);
    }

    public final void severe(String func, String msg, Throwable t) {
	if (ok)
	    logger.error(className + "." + func + " - " + msg, t);
    }
}
