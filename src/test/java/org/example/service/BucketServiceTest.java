package org.example.service;

import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author 'Mukhtarov Sarvarbek' on 8/1/2024
 * @project demo-simple-storage-service
 * @contact @sarvargo
 */
@SpringBootTest
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class BucketServiceTest {

    @Autowired
    private BucketService bucketService;

    @Test
    @Order(0)
    public void testCreateBucket_success() {
        bucketService.createBucket("mytestbucketforjava1232345568774444");
    }

    @Test
    @Order(1)
    public void testCreateBucket_fail() {
        Assertions.assertThrows(AmazonS3Exception.class, () -> bucketService.createBucket("java"));
    }

    @Test
    @Order(2)
    public void test() {
        List<Bucket> bucketList = bucketService.getBucketList();
        Assertions.assertFalse(bucketList.isEmpty());
    }

    @Test
    @Order(3)
    public void testValidateBucket_success() {
        boolean b = bucketService.validateBucket("mytestbucketforjava1232345568774444");
        Assertions.assertTrue(b);
    }

    @Test
    @Order(4)
    public void testDeleteBucket_success() {
        bucketService.deleteBucket("mytestbucketforjava1232345568774444");
    }

    @Test
    @Order(5)
    public void testDeleteBucket_fail() {
        Assertions.assertThrows(AmazonS3Exception.class, () -> bucketService.deleteBucket("mytestbucketforjava1232345568774444"));
    }

    @Test
    @Order(6)
    public void testValidateBucket_fail() {
        boolean b = bucketService.validateBucket("mytestbucketforjava1232345568774444");
        Assertions.assertFalse(b);
    }


}
