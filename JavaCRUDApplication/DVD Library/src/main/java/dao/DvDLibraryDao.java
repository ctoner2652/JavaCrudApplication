package dao;

import dto.DvD;

import java.util.List;

public interface DvDLibraryDao {

    DvD addDvD(String title, DvD dvD) throws DvDLibraryDaoException;

    DvD removeDvD(String title) throws DvDLibraryDaoException;

    DvD editDvD(String title, DvD dvd) throws DvDLibraryDaoException;

    List<DvD> getAllDvD() throws DvDLibraryDaoException;

    DvD getDvD(String title) throws DvDLibraryDaoException;

    void writeFile() throws DvDLibraryDaoException;

    void loadFile() throws DvDLibraryDaoException;

}
