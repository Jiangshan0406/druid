/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.druid.stat;

import org.springframework.beans.factory.FactoryBean;

public class JdbcStatManagerFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return JdbcStatManager.getInstance();
    }

    @Override
    public Class<?> getObjectType() {
        return JdbcStatManager.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
