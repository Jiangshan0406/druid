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
package com.alibaba.druid.bvt.sql.mysql.visitor;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;
import junit.framework.TestCase;

import java.util.List;

public class MySqlSchemaStatVisitorTest7_between extends TestCase {
    public void test_0() throws Exception {
        String sql = "select name from student where id = 4 and flag between 1 and 3";

//		sql = "select columnName from table1 where id in (select id from table3 where name = ?)";
        MySqlStatementParser parser = new MySqlStatementParser(sql);
        List<SQLStatement> statementList = parser.parseStatementList();
        SQLStatement stmt = statementList.get(0);

        assertEquals(1, statementList.size());

        MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
        stmt.accept(visitor);

        System.out.println(sql);
        System.out.println("Tables : " + visitor.getTables());
        System.out.println("fields : " + visitor.getColumns());
        System.out.println(visitor.getConditions());

        assertEquals(1, visitor.getTables().size());
        assertEquals(true, visitor.containsTable("student"));

        assertEquals(3, visitor.getColumns().size());
        assertEquals(true, visitor.containsColumn("student", "flag"));
        assertEquals(true, visitor.containsColumn("student", "id"));
        assertEquals(true, visitor.containsColumn("student", "name"));
        // assertEquals(true, visitor.getFields().contains(new
        // Column("users", "name")));

    }

}
