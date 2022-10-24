package com.astro.apiwebService.entities.enums;

/**
 * Entidade enum para classificar o status da ordem de um pedido.
 */
public enum OrderStatus {
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	/**
	 * Método para retornar o StatusCode de um pedido.
	 * @param code Referente a um dos tipos enumerado.
	 * @return O valor do StatusCode.
	 */
	public static OrderStatus valueOf(int code) {
		
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Invalid OrderStatus code");
		
	}
}
