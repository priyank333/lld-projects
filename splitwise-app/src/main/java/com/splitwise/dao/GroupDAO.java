/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.splitwise.dao;

import com.splitwise.model.Group;
import com.splitwise.model.User;
import com.splitwise.sql.SqlQueries;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author priyank
 */
@Repository
public class GroupDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SqlQueries sqlQueries;

    @Transactional
    public String addGroup(Group group) {
        String groupId = UUID.randomUUID().toString();
        group.setGroupId(groupId);
        int rowsAffected = jdbcTemplate.update(sqlQueries.addGroup, new Object[]{
            group.getGroupId(),
            group.getGroupName()
        });
        if (rowsAffected > 0) {
            List<User> groupUsers = group.getUsers();
            int[] result = jdbcTemplate.batchUpdate(sqlQueries.addGroupUser,
                    new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    User user = groupUsers.get(i);
                    ps.setString(1, user.getUserId());
                    ps.setString(2, group.getGroupId());
                }

                @Override
                public int getBatchSize() {
                    return groupUsers.size();
                }
            });
            int successCount = 0;
            for (int eachRowRes : result) {
                if (eachRowRes == 1) {
                    successCount++;
                }
            }
            return successCount == group.getUsers().size() ? groupId : null;
        }
        return null;
    }
}
