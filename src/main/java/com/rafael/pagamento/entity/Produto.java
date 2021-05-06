package com.rafael.pagamento.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.rafael.pagamento.data.vo.ProdutoVO;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "produto")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Produto {

	@Id	
	private Long id;

	@Column(name = "estoque", nullable = false, length = 10)
	private Integer estoque;

	public static Produto create(ProdutoVO produtoVO) {
		return new ModelMapper().map(produtoVO, Produto.class);
	}

}
