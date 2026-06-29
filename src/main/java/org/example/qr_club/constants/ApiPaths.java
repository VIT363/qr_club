package org.example.qr_club.constants;

public final class ApiPaths {

    private ApiPaths() {
    }

    public static final String API_V1 = "/api/v1";
    public static final String PARTICIPANTS = API_V1 + "/participants";
    public static final String QR_CODES = API_V1 + "/qr-codes";
    public static final String ACCESS = API_V1 + "/access";
    public static final String UUID_PATH = "/{uuid}";
}