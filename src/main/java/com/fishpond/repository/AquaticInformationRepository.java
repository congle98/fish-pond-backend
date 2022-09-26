package com.fishpond.repository;

import com.fishpond.model.AquaticInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AquaticInformationRepository extends JpaRepository<AquaticInformation,Long> {
    List<AquaticInformation> getAllByDeviceIdIn(List<Long> deviceIds);

    @Query(
            value = " select aquaticInformation.* from aquatic_information aquaticInformation inner join device device on aquaticInformation.device_id = device.id" +
                    " inner join fish_pond fishPond on device.fish_pond_id = fishPond.id " +
                    " inner join user user on fishPond.user_id = user.id" +
                    " where user.user_name = ?1 " +
                    " and (device.device_id like %?2% or fishPond.name like %?2% or fishPond.address like %?2% or fishPond.city like %?2%)",
            countQuery = " select count(*) from aquatic_information aquaticInformation inner join device device on aquaticInformation.device_id = device.id" +
                    " inner join fish_pond fishPond on device.fish_pond_id = fishPond.id " +
                    " inner join user user on fishPond.user_id = user.id" +
                    " where user.user_name = ?1 " +
                    " and (device.device_id like %?2% or fishPond.name like %?2% or fishPond.address like %?2% or fishPond.city like %?2%)",
            nativeQuery = true)
    Page<AquaticInformation> findAllByUser(String userName, String keyword, Pageable pageable);


    @Query(
            value = " select aquaticInformation.* from aquatic_information aquaticInformation" +
                    " inner join device device on aquaticInformation.device_id = device.id" +
                    " inner join fish_pond fishPond on device.fish_pond_id = fishPond.id " +
                    " inner join user user on fishPond.user_id = user.id " +
                    " where (device.device_id like %?1% or fishPond.name like %?1% or fishPond.address like %?1% or fishPond.city like %?1%)",

            countQuery = " select count(*) from aquatic_information aquaticInformation" +
                    " inner join device device on aquaticInformation.device_id = device.id" +
                    " inner join fish_pond fishPond on device.fish_pond_id = fishPond.id " +
                    " inner join user user on fishPond.user_id = user.id " +
                    " where (device.device_id like %?1% or fishPond.name like %?1% or fishPond.address like %?1% or fishPond.city like %?1%)",
            nativeQuery = true)
    Page<AquaticInformation> findAll(String keyword,Pageable pageable);


    @Query(
            value = " select aquaticInformation.* from aquatic_information aquaticInformation join (select max(create_date) create_date, device_id from aquatic_information group by device_id) sub" +
                    " on aquaticInformation.device_id = sub.device_id and aquaticInformation.create_date = sub.create_date" +
                    " inner join device device on aquaticInformation.device_id = device.id" +
                    " inner join fish_pond fishPond on device.fish_pond_id = fishPond.id " +
                    " inner join user user on fishPond.user_id = user.id " +
                    " where (device.device_id like %?1% or fishPond.name like %?1% or fishPond.address like %?1% or fishPond.city like %?1%)",

            countQuery =" select aquaticInformation.* from aquatic_information aquaticInformation join (select max(create_date) create_date, device_id from aquatic_information group by device_id) sub" +
                    " on aquaticInformation.device_id = sub.device_id and aquaticInformation.create_date = sub.create_date"+
                    " inner join device device on aquaticInformation.device_id = device.id" +
                    " inner join fish_pond fishPond on device.fish_pond_id = fishPond.id " +
                    " inner join user user on fishPond.user_id = user.id " +
                    "where (device.device_id like %?1% or fishPond.name like %?1% or fishPond.address like %?1% or fishPond.city like %?1%)",
            nativeQuery = true
    )
    Page<AquaticInformation> findAllOfDeviceUpdateDate(String keyword, Pageable pageable);


    @Query(
            value = " select * from (select aquaticInformation.* from aquatic_information aquaticInformation inner join device device on aquaticInformation.device_id = device.id" +
                    " inner join fish_pond fishPond on device.fish_pond_id = fishPond.id " +
                    " inner join user user on fishPond.user_id = user.id" +
                    " where device.id = ?1 ) as a order by a.create_date desc",
            countQuery = " select * from (select aquaticInformation.* from aquatic_information aquaticInformation inner join device device on aquaticInformation.device_id = device.id" +
                    " inner join fish_pond fishPond on device.fish_pond_id = fishPond.id " +
                    " inner join user user on fishPond.user_id = user.id" +
                    " where device.id = ?1 ) as a order by a.create_date desc",
            nativeQuery = true)
    Page<AquaticInformation> findAllByDevice(Long deviceId,Pageable pageable);



}
