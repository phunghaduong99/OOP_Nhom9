package oop.generatedata;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
public class ReadFile {
		@SuppressWarnings("finally")
		public List<String> readDataInFile(String path) {
			List<String> list = new ArrayList<String>();
			try(Stream<String> stream = Files.lines(Paths.get(path),StandardCharsets.UTF_8)){//đưa về dạng chuẩn utf8
				stream.forEach(line ->{
					list.add(line);
				});
			}
			catch (Exception e) {
				e.printStackTrace();
			}finally {
				return list;
			}
		}
		public String getOneInListString(List<String> listString) {
			List <String> list = listString;
			Random rd = new Random();
			int random = rd.nextInt(list.size());
			return list.get(random);
		}
}
