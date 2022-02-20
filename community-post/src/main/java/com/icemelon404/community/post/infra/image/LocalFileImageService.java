package com.icemelon404.community.post.infra.image;

import com.icemelon404.community.commons.exception.ServerError;
import com.icemelon404.community.post.domain.image.PostImageService;
import com.icemelon404.community.post.domain.dto.ImageData;
import com.icemelon404.community.post.domain.dto.ImageType;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class LocalFileImageService implements PostImageService {

    private final String baseDir;

    @Override
    public List<String> uploadAndGetIds(List<ImageData> images) {
        List<String> imageIds = new LinkedList<>();
        for (ImageData data : images)
            imageIds.add(writeToFile(data));
        return imageIds;
    }

    private String writeToFile(ImageData data ){
        String id = randomId();
        createMetadata(id, data.getImageType());
        writeImageData(dataFile(id, data.getImageType()), data);
        return id;
    }

    private void writeImageData(File file, ImageData data) {
        try {
            FileOutputStream stream = new FileOutputStream(file);
            stream.write(data.imageInputStream().readAllBytes());
        } catch (Exception e) {
            throw new ServerError("이미지 저장중에 오류가 발생하였습니다", e);
        }
    }

    private void createMetadata(String id, ImageType type) {
        try {
            FileUtils.writeStringToFile(dataFile(id, type), type.toString());
        } catch (IOException exception) {
            throw new ServerError("이미지 타입 저장 실패", exception);
        }
    }

    private ImageType readType(String id) {
        try {
            String typeStr = FileUtils.readFileToString(metadataFile(id));
            return ImageType.valueOf(typeStr);
        } catch (IOException exception) {
            throw new ServerError("이미지 타입 읽기 실패", exception);
        }
    }


    private String extension(ImageType type) {
        return switch (type) {
            case JPEG -> ".jpg";
            case PNG -> ".png";
        };
    }

    private String randomId() {
        return UUID.randomUUID().toString();
    }

    private File metadataFile(String id) {
        try {
            File dir = new File(baseDir);
            if (!dir.exists())
                dir.mkdirs();
            File file = new File(baseDir + File.separator + id + ".metadata");
            if (!file.exists())
                file.createNewFile();
            return file;
        } catch (Exception e) {
            throw new ServerError("", e);
        }
    }

    private File dataFile(String id, ImageType type) {
        try {
            File dir = new File(baseDir);
            if (!dir.exists())
                dir.mkdirs();
            File file = new File(baseDir + File.separator + id + extension(type));
            if (!file.exists())
                file.createNewFile();
            return file;
        } catch (Exception e) {
            throw new ServerError("", e);
        }
    }

    @Override
    public List<ImageData> getImageListByIds(List<String> imageIds) {
        return imageIds.stream()
                .map(this::getImageById)
                .collect(Collectors.toList());
    }


    @Override
    public ImageData getImageById(String imageId) {
        ImageType type = readType(imageId);
        InputStream input = inputStreamOf(dataFile(imageId, type));
        return new ImageData(type, available(input)) {
            @Override
            public InputStream imageInputStream() {
                return input;
            }
        };
    }

    private InputStream inputStreamOf(File file) {
        try {
            return new FileInputStream(file);
        } catch (Exception e) {
            throw new ServerError("", e);
        }
    }

    private int available(InputStream input){
        try {
            return input.available();
        } catch (Exception e) {
            throw new ServerError("", e);
        }
    }
}
