package uz.ollobergan.apicollector.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class VersionDto {
    private String _objVersion;
    private Timestamp _objTimestamp;
}
