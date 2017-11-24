package com.rosinante24.sekolahapp.response;

import java.util.List;

import lombok.Data;

/**
 * Created by Rosinante24 on 24/11/17.
 */
@Data
public class SekolahResponse {
    private List<DataSekolah> data;

    @Data
    public class DataSekolah {
        private String npsn;
        private String nama_sekolah;
        private String alamat;
        private String kelurahan;
        private String kecamatan;
        private String telp;
        private String kota;
        private String jenjang;
        private String lat;
        private String lng;
    }
}
