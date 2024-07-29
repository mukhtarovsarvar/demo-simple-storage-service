# In this tutorial, we’ll learn how to interact with the Amazon S3 (Simple Storage Service) storage system programmatically from Java.

## Prerequisites
### 1. AWS Account: You need an AWS account to create an S3 bucket and get access keys.
### 2. Java Development Kit (JDK): Ensure you have JDK 8 or higher installed.
### 3. Spring Boot: A basic understanding of Spring Boot.
### 4. AWS SDK for Java: We'll use this to interact with AWS S3.
## Steps

### 1. Create an S3 Bucket:
- Log in to your AWS Management Console.
- Navigate to S3 and create a new bucket (e.g., my-spring-boot-bucket).

### 2. Get AWS Credentials:
- Go to IAM (Identity and Access Management) in AWS.
- Create a new user with programmatic access and assign AmazonS3FullAccess policy.
- Save the Access Key ID and Secret Access Key.