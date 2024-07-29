package org.example.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.S3Object;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @author 'Mukhtarov Sarvarbek' on 7/29/2024
 * @project demo-simple-storage-service
 * @contact @sarvargo
 */
@Service
public class BucketServiceImpl implements BucketService {
    private final Logger LOG = LogManager.getLogger(BucketServiceImpl.class);

    private final AmazonS3 s3Client;

    public BucketServiceImpl(AmazonS3 s3Client) {
        this.s3Client = s3Client;
    }

    @Override
    public List<Bucket> getBucketList() {
        return s3Client.listBuckets();
    }

    @Override
    public boolean validateBucket(String bucketName) {
        return s3Client.doesBucketExistV2(bucketName);
    }

    @Override
    public void getObjectFromBucket(String bucketName, String objectName) throws IOException {
        S3Object object = s3Client.getObject(bucketName, objectName);
        Optional.ofNullable(object)
                .ifPresent(item -> {
                    LOG.info("name = {}",item.getKey());
                });
    }

    @Override
    public void putObjectIntoBucket(String bucketName, String objectName, String filePathToUpload) {

    }

    @Override
    public void createBucket(String bucket) {

    }
}
