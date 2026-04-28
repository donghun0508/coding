package com.seowon.coding.domain.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.Builder;

import java.util.List;

class PermissionChecker {

    /**
     * TODO #7: 코드를 최적화하세요
     * 테스트 코드`PermissionCheckerTest`를 활용하시면 작업 결과를 검증 할 수 있습니다.
     */
    public static boolean hasPermission(
            String userId,
            String targetResource,
            String targetAction,
            List<User> users,
            List<UserGroup> groups,
            List<Policy> policies
    ) {

        Map<String, List<String>> userMap = users.stream().collect(Collectors.toMap(u -> u.id, u -> u.groupIds));
        Map<String, List<String>> groupMap = groups.stream().collect(Collectors.toMap(ug -> ug.id, ug -> ug.policyIds));
        Map<String, List<Statement>> policyMap = policies.stream().collect(Collectors.toMap(p -> p.id, p -> p.statements));

        for (String userGroup : userMap.getOrDefault(userId, new ArrayList<>())) {
            for (String policy : groupMap.getOrDefault(userGroup, new ArrayList<>())) {
                for (Statement statement : policyMap.getOrDefault(policy, new ArrayList<>())) {
                    if (statement.actions.contains(targetAction) &&
                        statement.resources.contains(targetResource)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

class User {
    String id;
    List<String> groupIds;

    public User(String id, List<String> groupIds) {
        this.id = id;
        this.groupIds = groupIds;
    }
}

class UserGroup {
    String id;
    List<String> policyIds;

    public UserGroup(String id, List<String> policyIds) {
        this.id = id;
        this.policyIds = policyIds;
    }
}

class Policy {
    String id;
    List<Statement> statements;

    public Policy(String id, List<Statement> statements) {
        this.id = id;
        this.statements = statements;
    }
}

class Statement {
    List<String> actions;
    List<String> resources;

    @Builder
    public Statement(List<String> actions, List<String> resources) {
        this.actions = actions;
        this.resources = resources;
    }
}