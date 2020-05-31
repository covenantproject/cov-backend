package org.covn.vo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author SunilAnand
 * @since 2020-04-14
 **/
@Entity
@Table(name = "`UserPhotos`")
public class PhotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`PhotoId`")
    private Long photoId;

    @Column(name = "`PhotoPath`")
    private String photoPath;

//    @OneToOne(mappedBy = "photo", cascade = CascadeType.ALL)
//    private UserEntity user;

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
}
