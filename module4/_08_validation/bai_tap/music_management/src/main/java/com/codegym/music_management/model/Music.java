package com.codegym.music_management.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Music {

    @NotBlank(message = "tên bài hát không được để trống")
    @Length(max = 8, message = "tên bài hát vượt quá ký tự cho phép")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "tên bài hát không có ký tự đặc biệt")
    private String musicName;

    @NotBlank(message = "tên nghệ sĩ không được để trống")
    @Length(max = 10, message = "tên nghệ sĩ vượt quá ký tự cho phép")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "tên nghệ sĩ không có ký tự đặc biệt")
    private String singer;

    @NotBlank(message = "tên thể loại không được để trống")
    @Length(max = 10, message = "tên thể loại vượt quá ký tự cho phép")
    @Pattern(regexp = "^[a-zA-Z0-9 ,]+$", message = "tên thể loại không có ký tự đặc biệt")
    private String musicType;

    public Music() {
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getMusicType() {
        return musicType;
    }

    public void setMusicType(String musicType) {
        this.musicType = musicType;
    }
}
