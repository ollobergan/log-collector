package uz.ollobergan.appcollector.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class ExceptionDto extends VersionDto{
    private byte[] object;

    public ExceptionDto(String objVersion, byte[] object) {
        this.set_objVersion(objVersion);
        this.set_objTimestamp(new Timestamp(System.currentTimeMillis()));
        this.object = object;
    }
}
