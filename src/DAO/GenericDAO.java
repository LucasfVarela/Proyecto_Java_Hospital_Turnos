/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

// Interfaz DAO genérica
import java.util.List;
import java.util.Optional;

public interface GenericDAO<T, ID> {
    
    /**
     * Guarda una entidad en la base de datos
     * @param entity La entidad a guardar
     * @return La entidad guardada
     */
    T Insert(T entity) throws Exception;
    
    /**
     * Busca una entidad por su ID
     * @param id El ID de la entidad
     * @return Optional con la entidad si existe
     */
    T findById(int id) throws Exception;
    
    /**
     * Obtiene todas las entidades
     * @return Lista de todas las entidades
     */
    List<T> findAll() throws Exception;
    
    /**
     * Actualiza una entidad existente
     * @param entity La entidad a actualizar
     * @return La entidad actualizada
     */
    T update(T entity) throws Exception;
    
    /**
     * Elimina una entidad por su ID
     * @param id El ID de la entidad a eliminar
     */
    void deleteById(ID id) throws Exception;
    
      /**
     * DesActiva una entidad por su ID
     * @param id El ID de la entidad a eliminar
     */
    void SoftdeleteById(ID id) throws Exception;
    
    /**
     * Verifica si existe una entidad con el ID dado
     * @param id El ID a verificar
     * @return true si existe, false en caso contrario
     */
    boolean existsById(int id) throws Exception;
    
    /**
     * Cuenta el número total de entidades
     * @return El número total de entidades
     */
    long count() throws Exception;
}

