package uce.edu.ec.container;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import uce.edu.ec.service.ApiService;
import uce.edu.ec.model.Photo;
import uce.edu.ec.view.Window;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private ApiService nasaApiService;

    private Window window;

    public Controller() {
        window = new Window();
        window.searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadPhotos();
            }
        });
    }

    private void loadPhotos() {
        String camera = (String) window.cameraComboBox.getSelectedItem();
        String rover = (String) window.roverComboBox.getSelectedItem();
        int sol = (Integer) window.solComboBox.getSelectedItem();

        List<Photo> photos = nasaApiService.getPhotosByFilters(camera, rover, sol);

        StringBuilder resultHtml = new StringBuilder();
        for (Photo photo : photos) {
            resultHtml.append("<div>")
                    .append("<p>Photo ID: ").append(photo.getId()).append("</p>")
                    .append("<p>Camera: ").append(photo.getCamera().getName()).append("</p>")
                    .append("<p>Rover: ").append(photo.getRover().getName()).append("</p>")
                    .append("<p>Earth Date: ").append(photo.getEarth_date()).append("</p>")
                    .append("<p><a href=\"").append(photo.getImg_src()).append("\">Link</a></p>")
                    .append("<img src=\"").append(photo.getImg_src()).append("\" width=\"200\" height=\"200\"/>")
                    .append("</div><br/>");
        }

        if (photos.isEmpty()) {
            resultHtml.append("No photos found for the given filters.");
        }

        window.resultPane.setText(resultHtml.toString());
    }
}