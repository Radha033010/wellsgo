package com.element.utils;

public class CredentialsManager {

    private String environmentName;

    public CredentialsManager(TestNGParameters parameters) {
        environmentName = parameters.EnvironmentName;
    }

    private String readEnvVariable(String pattern) {
        String envSetting = pattern.replace("{{ENV}}", environmentName);
        String result = System.getenv(envSetting);

        return result;
    }

    public String getAnalystUsername() {
        String pattern = "element_autotest_{{ENV}}_creds_analyst_username";
        return readEnvVariable(pattern);
    }

    public String getAdminUsername() {
        String pattern = "element_autotest_{{ENV}}_creds_admin_username";
        return readEnvVariable(pattern);
    }

    public String getAnalystPassword() {
        String pattern = "element_autotest_{{ENV}}_creds_analyst_password";
        return readEnvVariable(pattern);
    }

    public String getAdminPassword() {
        String pattern = "element_autotest_{{ENV}}_creds_admin_password";
        return readEnvVariable(pattern);
    }

    public String getGroupPermissionsPassword(String uname) {
        String pattern = String.format("element_autotest_{{ENV}}_creds_%s_password", uname.toLowerCase());
        return readEnvVariable(pattern);
    }

}

