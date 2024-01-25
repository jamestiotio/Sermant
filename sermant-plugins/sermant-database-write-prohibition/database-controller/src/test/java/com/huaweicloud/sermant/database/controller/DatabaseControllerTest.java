/*
 *  Copyright (C) 2024-2024 Huawei Technologies Co., Ltd. All rights reserved.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.huaweicloud.sermant.database.controller;

import com.huaweicloud.sermant.core.plugin.agent.entity.ExecuteContext;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Method;

/**
 * 数据库控制器单元测试
 *
 * @author daizhenyu
 * @since 2024-01-23
 **/
public class DatabaseControllerTest {
    private ExecuteContext context;

    private String database;

    @Before
    public void setUp() {
        context = ExecuteContext.forMemberMethod(new Object(), Mockito.mock(Method.class), null, null, null);
        database = "database-test";
    }

    @Test
    public void testDisableDatabaseWriteOperation() {
        DatabaseController.disableDatabaseWriteOperation(database, context);
        Assert.assertEquals("Database prohibit to write, database: database-test",
                context.getThrowableOut().getMessage());
    }

    @After
    public void tearDown() {
        Mockito.clearAllCaches();
    }
}
