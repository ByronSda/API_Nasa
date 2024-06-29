package uce.edu.ec.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uce.edu.ec.model.Photo;


@Service
public class ApiService {
    private final String API_KEY = "OttclxIXg8T1xmy7yZuVwZHHWRixK4VXZ6FSblLC";
    private final String URL = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?api_key=" + API_KEY;

    public List<Photo> getPhotosByFilters(String camera, String rover, int sol) {
        RestTemplate restTemplate = new RestTemplate();
        String url = URL + "&sol=" + sol;
        if (!camera.equals("All")) {
            url += "&camera=" + camera;
        }
        NasaResponse response = restTemplate.getForObject(url, NasaResponse.class);

        List<Photo> photos = response.getPhotos();
        if (!rover.equals("All")) {
            photos = photos.stream()
                    .filter(photo -> photo.getRover().getName().equalsIgnoreCase(rover))
                    .collect(Collectors.toList());
        }

        return photos;
    }

    // Clase interna para mapear la respuesta
    static class NasaResponse {
        private List<Photo> photos;

        public List<Photo> getPhotos() {
            return photos;
        }

        public void setPhotos(List<Photo> photos) {
            this.photos = photos;
        }
    }
}