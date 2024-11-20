package controller;

import dao.DvDLibraryDao;
import dao.DvDLibraryDaoException;
import dao.DvDLibraryDaoImpl;
import dto.DvD;
import ui.DvDLibraryView;

public class DvDController {
    DvDLibraryView view = new DvDLibraryView();
    DvDLibraryDao dao = new DvDLibraryDaoImpl();

    public void run(){
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {
                menuSelection = view.PrintMenuGetSelection();

                switch (menuSelection) {
                    case 1:
                        createDvD();
                        break;
                    case 2:
                        removeDvD();
                        break;
                    case 3:
                        editDvd();
                        break;
                    case 4:
                        getAllDvDs();
                        break;
                    case 5:
                        getDvD();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        //Print Error Message
                }
            }
        }catch(DvDLibraryDaoException e){

        }
    }
    private void createDvD() throws DvDLibraryDaoException {
        view.displayAddDVD();
        DvD newDvd = view.getNewDvDInfo();
        dao.addDvD(newDvd.getTitle(), newDvd);
        view.displayCompletedAddiction();
    }
    private void getAllDvDs() throws DvDLibraryDaoException{
        view.getAllDvDs(dao.getAllDvD());

    }
    private void getDvD()throws DvDLibraryDaoException{
        DvD searchedDvD = dao.getDvD(view.askForTitle());
        view.getDvD(searchedDvD);

    }
    private void removeDvD() throws DvDLibraryDaoException{
        view.displayRemoveDvD();
        String dvd = view.askForTitle();
        dao.removeDvD(dvd);
        view.displayRemovedDvD();
    }
    private void editDvd() throws DvDLibraryDaoException{

        String title = view.askForTitle();
        while(true) {
            if (dao.getDvD(title) == null) {
                view.titleNotFound();
                 view.askForTitle();

            }else{

                break;
            }
        }

        int menuSelection = view.printeEditMenu();
        dao.editDvD(title,view.editDvD(dao.getDvD(title), menuSelection));

    }
}
