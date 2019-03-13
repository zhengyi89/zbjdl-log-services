package com.zbjdl.common.log.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.mapping.ResultMapping;

import com.zbjdl.common.utils.BeanUtils;
import com.zbjdl.common.utils.CheckUtils;
import com.zbjdl.common.exception.BaseException;
import com.zbjdl.common.page.PageList;
import com.zbjdl.common.page.Paginator;
import com.zbjdl.utils.query.QueryResult;


public class DataConvertUtils {
	public static <T> T convert(Object source, Class<T> target) {
		if (source == null) {
			return null;
		}
		try {
			T t = target.newInstance();
			BeanUtils.copyProperties(source, t);
			return t;
		} catch (Throwable e) {
			throw new BaseException(e);
		}
	}

	public static <T> List<T> convert(List<?> source, Class<T> target) {
		List<T> ret = new ArrayList<T>();
		if (source == null || source.isEmpty()) {
			return ret;
		}
		try {
			for (Object s : source) {
				T t = target.newInstance();
				BeanUtils.copyProperties(s, t);
				ret.add(t);
			}
		} catch (Throwable e) {
			throw new BaseException(e);
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	public static <T> PageList convert(QueryResult queryResult,
			List<ResultMapping> mappings, Class<T> target) {
		PageList result = new PageList();
		Paginator paginator = new Paginator();
		paginator.setOffset(queryResult.getStartIndex());
		paginator.setPageSize(queryResult.getMaxFetchSize());
		paginator.setTotalCount(queryResult.getTotalCount().intValue());
		result.setPaginator(paginator);
		if (queryResult.getTotalCount() > 0) {
			try {
				List<Map<String, Object>> dataList = (List<Map<String, Object>>) queryResult
						.getData();
				for (Map<String, Object> row : dataList) {
					T t = target.newInstance();
					for (ResultMapping mapping : mappings) {
						try {
							BeanUtils.invokeSetter(t, mapping.getProperty(),
									row.get(mapping.getColumn()), true, true);
						} catch (Exception e) {
						}
					}
					result.add(t);
				}
			} catch (Exception e) {
			}
		}
		return result;
	}

	public static PageList cutToPageList(List<?> data, int pageNo, int pageSize) {
		Paginator paginator = new Paginator(pageSize, data.size());
		paginator.setPage(pageNo);

		PageList pageList = new PageList();
		pageList.setPaginator(paginator);
		if (data != null && !data.isEmpty()) {
			for (int index = paginator.getBeginIndex() - 1; index < paginator
					.getEndIndex(); index++) {
				pageList.add(data.get(index));
			}
		}
		return pageList;
	}

	public static <T> List<T> sort(List<T> list, final String sortBy) {
		CheckUtils.notNull(list, "list");
		CheckUtils.notNull(sortBy, "sortBy property");
		Collections.sort(list, new Comparator<T>() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public int compare(T obj1, T obj2) {
				Comparable value1 = (Comparable) BeanUtils.getProperty(obj1,
						sortBy);
				Comparable value2 = (Comparable) BeanUtils.getProperty(obj2,
						sortBy);
				if (value1 == null && value2 == null) {
					return 0;
				}
				if (value1 == null) {
					return -1;
				}
				if (value2 == null) {
					return 1;
				}
				return value1.compareTo(value2);
			}
		});
		return list;
	}
}
