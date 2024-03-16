package uz.ollobergan.apicollector.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class MessageDto extends VersionDto{
    private byte[] object;

    public MessageDto(String objVersion, byte[] object) {
        this.set_objVersion(objVersion);
        this.set_objTimestamp(new Timestamp(System.currentTimeMillis()));
        this.object = object;
    }
}
