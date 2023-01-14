package com.example.orderservice.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Location")
public class Location {
    @Id
    private String _id;
    private String detail;
    private String county;

    public Location() {
    }

    public Location(String _id,String detail,String county) {
        this._id = _id;
        this.detail = detail;
        this.county = county;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }
}
