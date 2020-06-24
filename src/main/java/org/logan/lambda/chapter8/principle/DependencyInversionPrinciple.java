package org.logan.lambda.chapter8.principle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * desc: 依赖反转原则 <br/>
 * time: 2020/6/23 6:13 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class DependencyInversionPrinciple {

	public interface HeadingFinder {
		List<String> findHeadings(Reader reader) throws Exception;
	}

	// 没有依赖反转 的写法
	public static class NoDIP implements HeadingFinder {
		@Override
		public List<String> findHeadings(Reader input) throws Exception {
			try (BufferedReader reader = new BufferedReader(input)) {
				return reader.lines()
						.filter(line -> line.endsWith(":"))
						.map(line -> line.substring(0, line.length() - 1))
						.collect(Collectors.toList());
			} catch (IOException e) {
				throw new Exception("");
			}
		}
	}

	// 有依赖反转 的写法
	public static class ExtractedDIP implements HeadingFinder {
		@Override
		public List<String> findHeadings(Reader input) throws Exception {
			return withLinesOf(input,
					// 专门读取文件行
					lines -> lines.filter(line -> line.endsWith(":"))
							.map(line -> line.substring(0, line.length() - 1))
							.collect(Collectors.toList()),
					RuntimeException::new
			);
		}

		// 专门读取文件流、关闭文件流
		private <T> T withLinesOf(Reader input,
								  Function<Stream<String>, T> handler,
								  Function<IOException, RuntimeException> error
		) {
			try (BufferedReader reader = new BufferedReader(input)) {
				return handler.apply(reader.lines());
			} catch (IOException e) {
				throw error.apply(e);
			}
		}

	}

}