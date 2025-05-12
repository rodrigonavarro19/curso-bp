package comportamiento.chainOfResponsibility;

/**
 * Enum representando el posible estado de diversos tickets.
 */
public enum EstadoTicket {
    APROBADO,   /**< Estado para tickets que son aprobados. */
    RECHAZADO,  /**< Estado para tickets que son rechazados. */
    EN_ESPERA   /**< Estado para tickets que quedan en espera a una definición manual. */
}
