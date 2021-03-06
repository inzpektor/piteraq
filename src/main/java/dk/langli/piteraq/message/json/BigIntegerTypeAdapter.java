package dk.langli.piteraq.message.json;

import java.io.IOException;
import java.math.BigInteger;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import dk.langli.piteraq.NumberUtil;

public class BigIntegerTypeAdapter extends TypeAdapter<BigInteger> {
	@Override
	public void write(JsonWriter out, BigInteger value) throws IOException {
		out.setHtmlSafe(false);
		out.value(NumberUtil.toBase64(value));
	}

	@Override
	public BigInteger read(JsonReader in) throws IOException {
		return NumberUtil.toBigInteger(in.nextString());
	}
}
