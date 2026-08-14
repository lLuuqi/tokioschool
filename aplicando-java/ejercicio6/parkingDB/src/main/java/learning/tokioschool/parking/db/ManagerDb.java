package learning.tokioschool.parking.db;

import learning.tokioschool.parking.Coche;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ManagerDb extends ManagerDbAbstract {
    /**
     * Actualiza un registro por matricula con la hora de salida
     *
     * @param matricula
     * @param horaSalida
     * @return
     */
    @Override
    public int update(String matricula, LocalDateTime horaSalida) {
        try (Connection connection = iniConexion()) {
            try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {

                statement.setObject(1, horaSalida);
                statement.setString(2, matricula);

                return statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Inserta un registro en base de datos
     *
     * @param matricula
     * @param coche
     * @return
     */
    @Override
    public int insert(String matricula, Coche coche) {

        try (Connection connection = iniConexion()) {

            try (PreparedStatement statement = connection.prepareStatement(INSERT)) {

                statement.setString(1, matricula);
                statement.setString(2, coche.getMarca());
                statement.setString(3, coche.getModelo());
                statement.setObject(4, coche.getHoraEntrada());
                statement.setObject(5, coche.getHoraSalida());

                return statement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

        /**
         * Recupera un coche buscando por matricula
         *
         * @param matricula
         * @return
         */
        @Override
        public Coche search (String matricula){
            try (Connection connection = iniConexion()) {
                try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_MATRICULA)) {

                    statement.setString(1, matricula);

                    try (ResultSet resultSet = statement.executeQuery()) {

                        if (resultSet.next()) {
                            String marca = resultSet.getString("Marca");
                            String modelo = resultSet.getString("Modelo");
                            LocalDateTime horaEntrada =
                                    resultSet.getObject("HoraEntrada", LocalDateTime.class);
                            LocalDateTime horaSalida =
                                    resultSet.getObject("HoraSalida", LocalDateTime.class);

                            return new Coche (marca, modelo, horaEntrada, horaSalida);
                        }
                    }
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }

        /**
         * Busca todos los coches del sistema
         *
         * @return
         */
        @Override
        public Map<String, Coche> searchAll () {

            Map<String, Coche> coches = new HashMap<>();

            try (Connection connection = iniConexion()) {
                try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL)) {
                    try (ResultSet resultSet = statement.executeQuery()) {
                        while (resultSet.next()) {

                            String matricula = resultSet.getString("Matricula");
                            String marca = resultSet.getString("Marca");
                            String modelo = resultSet.getString("Modelo");
                            LocalDateTime horaEntrada =
                                    resultSet.getObject("HoraEntrada", LocalDateTime.class);
                            LocalDateTime horaSalida =
                                    resultSet.getObject("HoraSalida", LocalDateTime.class);

                            Coche coche = new Coche(marca, modelo,  horaEntrada, horaSalida);

                            coches.put(matricula, coche);
                        }
                    }
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            return coches;
        }

        /**
         * Busca todos los coches del sistema filtrando por hora de salida igual a NULL
         *
         * @return
         */
        @Override
        public Map<String, Coche> searchAllFilterHoraSalida () {
            Map<String, Coche> coches = new HashMap<>();

            try (Connection connection = iniConexion()) {
                try (PreparedStatement statement =
                             connection.prepareStatement(SELECT_ALL_WITHOUT_HORA_SALIDA)) {
                    try (ResultSet resultSet = statement.executeQuery()) {
                        while (resultSet.next()) {

                            String matricula = resultSet.getString("Matricula");
                            String marca = resultSet.getString("Marca");
                            String modelo = resultSet.getString("Modelo");
                            LocalDateTime horaEntrada =
                                    resultSet.getObject("HoraEntrada", LocalDateTime.class);
                            LocalDateTime horaSalida =
                                    resultSet.getObject("HoraSalida", LocalDateTime.class);

                            Coche coche = new Coche(marca, modelo,  horaEntrada, horaSalida);

                            coches.put(matricula, coche);
                        }
                    }
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            return coches;
        }
    }
