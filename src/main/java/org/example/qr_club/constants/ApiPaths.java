package org.example.qr_club.constants;

public final class ApiPaths {

    private ApiPaths() {
    }

    public static final String API = "/api";
    public static final String V1 = "/v1";
    public static final String PARTICIPANTS = API + "/participants";
    public static final String QR_CODES = API + "/qr-codes";
    public static final String ACCESS = API + V1 + "/access";
    public static final String UUID_PATH = "/{uuid}";
}