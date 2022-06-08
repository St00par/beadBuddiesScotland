package com.beadbuddiesscotland.web.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

	@Entity
	public class BeadModel {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private double cost;
		private String material;
		private String type;
		private String image;

		public BeadModel() {
			super();
		}

		public BeadModel(int id, double cost, String material, String type, String image) {
			super();
			this.id = id;
			this.cost = cost;
			this.material = material;
			this.type = type;
			this.image = image;
		}

		public BeadModel(double cost, String material, String type, String image) {
			super();
			this.cost = cost;
			this.material = material;
			this.type = type;
			this.image = image;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public double getCost() {
			return cost;
		}

		public void setCost(double cost) {
			this.cost = cost;
		}

		public String getMaterial() {
			return material;
		}

		public void setMaterial(String material) {
			this.material = material;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		@Override
		public int hashCode() {
			return Objects.hash(cost, id, material, type, image);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			BeadModel other = (BeadModel) obj;
			return Double.doubleToLongBits(cost) == Double.doubleToLongBits(other.cost) && id == other.id
					&& Objects.equals(material, other.material) && Objects.equals(type, other.type) && Objects.equals(image, other.image);
		}

		@Override
		public String toString() {
			return "CRUDModel [id=" + id + ", cost=" + cost + ", material=" + material + ", type=" + type + ", image=" + image + "]";
		}
	}