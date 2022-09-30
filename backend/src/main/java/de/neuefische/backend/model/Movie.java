package de.neuefische.backend.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private String id;
    private String title;
    private String releaseYear;
    private String poster;
 }
