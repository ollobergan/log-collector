package uz.ollobergan.apicollector.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import uz.ollobergan.apicollector.dto.MessageDto;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class CompressHelper {
    public static MessageDto CompressMessageDto(String appName, int priority, Object message) throws  Exception{
        ObjectMapper jsonObjectMapper = new ObjectMapper();
        return new MessageDto((appName+'.'+priority), CompressHelper.Compress(jsonObjectMapper.writeValueAsString(message)));
    }

    public static byte[] Compress(String str) throws Exception {
        ByteArrayOutputStream obj = new ByteArrayOutputStream();
        try (GZIPOutputStream gzip = new GZIPOutputStream(obj)) {
            gzip.write(str.getBytes("UTF-8"));
        }
        return obj.toByteArray();
    }

    public static String Decompress(byte[] bytes) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(bytes)))
        {
            int b;
            while ((b = gis.read()) != -1) {
                baos.write((byte) b);
            }
        }
        return new String(baos.toByteArray(), "UTF-8");
    }
}
