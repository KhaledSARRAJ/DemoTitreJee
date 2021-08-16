//import.sql est un script SQL automatiquement déclenché par hibernate 
//au démarrage de appli (ou test) en mode hibernate.hbm2ddl.auto=create  
INSERT INTO `school` (id, name, phone, email, address1, note) VALUES (1,"David", "0606060606", "david@gmail.com","paris", "Amis");
INSERT INTO `school` (id, name, phone, email, address1, note) VALUES (2,"Mikael","0707070707","mikael@gmail.com","rennes","professionnel");
INSERT INTO `school` (id, name, phone, email, address1, note) VALUES (3,"Thomas","0202020202", "thomas@gmail.com","nantes","Agriculteur");
