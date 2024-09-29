package com.vineet.Taxi.Booking.Application.service;

import com.vineet.Taxi.Booking.Application.dao.ServiceFormRepo;
import com.vineet.Taxi.Booking.Application.model.ServiceForm;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.util.List;
@Service
public class ServiceFormServiceImpl implements ServiceFormService{

    private ServiceFormRepo serviceFormRepo;

    @Autowired
    public void setServiceFormCrud(ServiceFormRepo serviceFormRepo) {
        this.serviceFormRepo = serviceFormRepo;
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public ServiceForm addService(ServiceForm serviceForm, MultipartFile multipartFile) throws Exception {

        ServiceForm save =null;
        try {

            save = serviceFormRepo.save(serviceForm);
            if(save!=null) {

                String path="D:\\Projects\\Taxi-Booking-Application\\src\\main\\resources\\static\\myserviceimg\\"+multipartFile.getOriginalFilename();
                byte[] bytes = multipartFile.getBytes();

                FileOutputStream fos = new FileOutputStream(path);
                fos.write(bytes);
            }

        } catch (Exception e) {
            save=null;
            throw e;
        }
        return save;
    }

    @Override
    public List<ServiceForm> readAllServices() {

        return serviceFormRepo.findAll();
    }
}
