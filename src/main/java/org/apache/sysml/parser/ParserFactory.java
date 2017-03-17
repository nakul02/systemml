/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.sysml.parser;

import org.apache.sysml.api.ScriptType;
import org.apache.sysml.parser.common.CommonSyntacticValidator;
import org.apache.sysml.parser.dml.DMLParserWrapper;
import org.apache.sysml.parser.pydml.PyDMLParserWrapper;

public class ParserFactory {

	/**
	 * Factory method for creating parser wrappers
	 * 
	 * @param scriptType
	 *            type of script
	 * @return parser wrapper (DMLParserWrapper or PyDMLParserWrapper)
	 */
	public static ParserWrapper createParser(ScriptType scriptType) {
		ParserWrapper ret = null;

		// create the parser instance
		switch (scriptType) {
			case DML: ret = new DMLParserWrapper(); break;
			case PYDML: ret = new PyDMLParserWrapper(); break;
		}
		CommonSyntacticValidator.init();

		return ret;
	}

}
