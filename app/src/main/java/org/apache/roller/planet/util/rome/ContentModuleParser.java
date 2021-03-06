/*
 * Copyright 2004 Sun Microsystems, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.apache.roller.planet.util.rome;

import org.jdom2.Element;
import org.jdom2.Namespace;

import com.rometools.rome.feed.module.Module;
import com.rometools.rome.io.ModuleParser;
import java.util.Locale;

public class ContentModuleParser implements ModuleParser {

    @Override
    public String getNamespaceUri() {
        return ContentModule.URI;
    }

    public Namespace getContentNamespace() {
        return Namespace.getNamespace(ContentModule.URI);
    }
    @Override
    public Module parse(Element element, Locale locale) {
        boolean foundSomething = false;
        ContentModule fm = new ContentModuleImpl();

        Element e = element.getChild("encoded", getContentNamespace());
        if (e != null) {
            foundSomething = true;
            fm.setEncoded(e.getText());
        }
        return (foundSomething) ? fm : null;
    }
}

