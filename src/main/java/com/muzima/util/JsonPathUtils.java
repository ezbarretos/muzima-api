/**
 * Copyright 2012 Muzima Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.muzima.util;

import com.jayway.jsonpath.JsonPath;
import com.muzima.search.api.util.ISO8601Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * TODO: Write brief description about the class here.
 */
public class JsonPathUtils {

    private static final Logger logger = LoggerFactory.getLogger(JsonPathUtils.class.getSimpleName());

    public static boolean readAsBoolean(final Object jsonObject, final String path) {
        boolean returnedBoolean = false;
        try {
            returnedBoolean = JsonPath.read(jsonObject, path);
        } catch (Exception e) {
            logger.error("Unable to read boolean value with path: " + path + " from: " + String.valueOf(jsonObject));
        }
        return returnedBoolean;
    }

    public static double readAsNumeric(final Object jsonObject, final String path) {
        double returnedString = 0;
        try {
            returnedString = JsonPath.read(jsonObject, path);
        } catch (Exception e) {
            logger.error("Unable to read string value with path: " + path + " from: " + String.valueOf(jsonObject));
        }
        return returnedString;
    }

    public static String readAsString(final Object jsonObject, final String path) {
        String returnedString = null;
        try {
            returnedString = JsonPath.read(jsonObject, path);
        } catch (Exception e) {
            logger.error("Unable to read string value with path: " + path + " from: " + String.valueOf(jsonObject));
        }
        return returnedString;
    }

    public static Date readAsDate(final Object jsonObject, final String path) {
        Date returnedDate = null;
        try {
            String dateAsString = readAsString(jsonObject, path);
            Calendar calendar = ISO8601Util.toCalendar(dateAsString);
            returnedDate = calendar.getTime();
        } catch (ParseException e) {
            logger.error("Unable to convert string value from path: " + path + " from: " + String.valueOf(jsonObject));
        } catch (Exception e) {
            logger.error("Unable to create date value from path: " + path + " from: " + String.valueOf(jsonObject));
        }
        return returnedDate;
    }

}
