package com.atguigu.es.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

public class ESTest_Doc_Batch_Insert {
    public static void main(String[] args) throws IOException {
        //建立链接
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        BulkRequest request = new BulkRequest();
        request.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON,"name","zhangsan","sex","男","age","30"));
        request.add(new IndexRequest().index("user").id("1002").source(XContentType.JSON,"name","lisi","sex","女","age","30"));
        request.add(new IndexRequest().index("user").id("1003").source(XContentType.JSON,"name","wangwu","sex","男","age","40"));
        request.add(new IndexRequest().index("user").id("1004").source(XContentType.JSON,"name","zhaoliu","sex","女","age","50"));
        request.add(new IndexRequest().index("user").id("1005").source(XContentType.JSON,"name","niuqi","sex","男","age","40"));
        request.add(new IndexRequest().index("user").id("1006").source(XContentType.JSON,"name","wangba","sex","女","age","60"));

        BulkResponse response = esClient.bulk(request, RequestOptions.DEFAULT);
        System.out.println(response);
        //关闭链接
        esClient.close();
    }
}
