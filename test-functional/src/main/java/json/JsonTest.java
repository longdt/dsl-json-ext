package json;

import com.dslplatform.json.DslJson;
import com.dslplatform.json.JsonReader;
import com.dslplatform.json.runtime.Settings;
import model.Order;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class JsonTest {
    public static void main(String[] args) throws IOException {
        var order = new Order().setId(1L)
                .setServiceName("Fast")
                .setServiceCode("F")
                .setDescription("Fast delivery");
        DslJson<Object> dslJson = new DslJson<>(Settings.withRuntime()
                .unknownNumbers(JsonReader.UnknownNumberParsing.LONG_AND_DOUBLE)
                .allowArrayFormat(true)
                .includeServiceLoader());
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        dslJson.serialize(order, stream);
        System.out.println(stream.toString(StandardCharsets.UTF_8));
        var order1 = dslJson.deserialize(Order.class, new ByteArrayInputStream(stream.toByteArray()));
        System.out.println(order1);
        order1 = dslJson.deserialize(Order.class, new ByteArrayInputStream("{\"service_name\":\"Fast\",\"id\":1,\"description\":\"Fast delivery\",\"service_code\":\"F\"}".getBytes(StandardCharsets.UTF_8)));
        System.out.println(order1);
    }
}
