package org.logan.lambda.chapter5.helper;

/**
 * desc: String 合并器 <br/>
 * jdk实现：{@link java.util.StringJoiner}
 * time: 2018/11/11 下午17:11 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class StringCombiner {

	/**
	 * 分割
	 */
	private final String delimit;
	/**
	 * 前缀
	 */
	private final String prefix;
	/**
	 * 后缀
	 */
	private final String suffix;

	private final StringBuilder builder;


	public StringCombiner(String delimit, String prefix, String suffix) {
		this.delimit = delimit;
		this.prefix = prefix;
		this.suffix = suffix;
		builder = new StringBuilder();
	}


	public StringCombiner add(String element) {
		if (areAtStart()) {
			builder.append(prefix);
		} else {
			builder.append(delimit);
		}
		builder.append(element);
		return this;
	}

	private boolean areAtStart() {
		return builder.length() == 0;
	}

	public StringCombiner merge(StringCombiner other) {
		builder.append(other.builder);
		return this;
	}

	public StringCombiner merge2(StringCombiner other) {
		if (other.builder.length() > 0) {
			if (areAtStart()) {
				builder.append(prefix);
			} else {
				builder.append(delimit);
			}
			builder.append(other.builder, prefix.length(), other.builder.length());
		}
		return this;
	}


	@Override
	public String toString() {
		if (areAtStart()) {
			builder.append(prefix);
		}
		builder.append(suffix);
		return builder.toString();
	}

}
