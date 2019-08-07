package com.sumukh.librarymanagementsystem.elastic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Slf4j
public class ElasticParserUtils {

    private ElasticParserUtils() {
    }

    /**
     * Parse the {@link SearchHit} to create an object of T
     */
    public static <T> T parse(SearchHit hit, Class<T> clazz) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(hit.getSourceAsString(), clazz);
    }

    /**
     * Parse the SearchHists to create the list of non-null T type objects
     *
     * @param hits
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> parse(SearchHits hits, Class<T> clazz) {
        return Arrays.stream(hits.getHits())
            .map(hit -> ElasticParserUtils.parse(hit, clazz))
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }

}
