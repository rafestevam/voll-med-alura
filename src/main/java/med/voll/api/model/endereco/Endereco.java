package med.voll.api.model.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(EnderecoDTO endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
    }

    public void update(EnderecoDTO dadosEndereco) {
        this.logradouro = dadosEndereco.logradouro() != null ? dadosEndereco.logradouro() : this.logradouro;
        this.bairro = dadosEndereco.bairro() != null ? dadosEndereco.bairro() : this.bairro;
        this.cep = dadosEndereco.cep() != null ? dadosEndereco.cep() : this.cep;
        this.numero = dadosEndereco.numero() != null ? dadosEndereco.numero() : this.numero;
        this.complemento = dadosEndereco.complemento() != null ? dadosEndereco.complemento() : this.complemento;
        this.cidade = dadosEndereco.cidade() != null ? dadosEndereco.cidade() : this.cidade;
        this.uf = dadosEndereco.uf() != null ? dadosEndereco.uf() : this.uf;
    }
}
