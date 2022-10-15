package com.toolstoreapp.cService;


import com.toolstoreapp.Personalizado.StatusAmount;
import com.toolstoreapp.aEntities.Reservation;
import com.toolstoreapp.Personalizado.CountClient;
import com.toolstoreapp.bRepository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    public Optional<Reservation> getProduct(int id){
        return reservationRepository.getReservation(id);
    }
    public Reservation save(Reservation p){
        p.setStatus("created");
        if(p.getIdReservation()==null){
            return reservationRepository.save(p);
        }else{
            Optional<Reservation> e = reservationRepository.getReservation(p.getIdReservation());
            if(e.isPresent()){
                return p;
            }else{
                return reservationRepository.save(p);
            }
        }
    }
    public Reservation update(Reservation p){
        if(p.getIdReservation()!=null){
            Optional<Reservation> q = reservationRepository.getReservation(p.getIdReservation());
            if(q.isPresent()){

                if(p.getStartDate()!=null){
                    q.get().setStartDate(p.getStartDate());
                }
                if(p.getDevolutionDate()!=null){
                    q.get().setDevolutionDate(p.getDevolutionDate());
                }
                reservationRepository.save(q.get());
                return q.get();
            }else{
                return p;
            }
        }else{
            return p;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Reservation>p= reservationRepository.getReservation(id);
        if(p.isPresent()){
            reservationRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }





    public List<CountClient> getTopClients(){

        return reservationRepository.getTopClient();
    }

    public StatusAmount getReservationStatusReport(){
        List<Reservation> completed = reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationByStatus("cancelled");
        return new StatusAmount(completed.size(),cancelled.size());
    }

    public List<Reservation> getReservationPeriod(String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();

        try{
            a = parser.parse(datoA);
            b = parser.parse(datoB);
        }catch(ParseException e){
            e.printStackTrace();
        }
        if(a.before(b)){
            return reservationRepository.getReservatioPeriod(a, b);
        }else{
            return new ArrayList<>();
        }
    }



}
